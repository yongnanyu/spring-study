package com.yyn.sharing.knowledge.config;

import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.yyn.sharing.knowledge.annotation.ApiModelEnumProperty;
import com.yyn.sharing.knowledge.enums.DefaultEnum;
import com.yyn.sharing.knowledge.enums.NameValueEnum;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PropertySpecificationBuilder;
import springfox.documentation.schema.Annotations;
import springfox.documentation.service.AllowableListValues;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.empty;


@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER)
public class ApiModelEnumPropertyBuilder implements ModelPropertyBuilderPlugin {
	@Override
	public void apply(ModelPropertyContext context) {
		Optional<ApiModelEnumProperty> annotation = empty();
		Optional<BeanPropertyDefinition> bpd = context.getBeanPropertyDefinition();
		if (bpd.isEmpty()) {
			return ;
		}
			annotation = annotation.or(() -> Annotations.findPropertyAnnotation(bpd.get(), ApiModelEnumProperty.class));
		if (annotation.isPresent()) {

			Class<?> enumClass = annotation.get().enumClass();
			// 是否为枚举类型
//			boolean isEnumType = Enum.class.isAssignableFrom(rawType);
			// 枚举类型为default是，从字段上获取该类型
			if (enumClass == DefaultEnum.class) {
				enumClass = bpd.get().getField().getRawType();
			}
			NameValueEnum<?, ?>[] enumConstants = (NameValueEnum<?, ?>[]) enumClass.getEnumConstants();

			PropertySpecificationBuilder propertyBuilder = context.getSpecificationBuilder();

			propertyBuilder.description(annotation.get().description());
			propertyBuilder.required(annotation.get().required());

			String[] values = annotation.get().values();
			AllowableListValues listValues;
			// 支持values属性，如果value不为空的话，优先判断value中的属性
			if (ArrayUtils.isNotEmpty(values)) {
				List<String> list = new ArrayList<>();
				for (NameValueEnum<?, ?> enumConstant : enumConstants) {
					String code = String.valueOf(enumConstant.getValue());
					if (ArrayUtils.contains(values, code)) {
						list.add(getPair(code, enumConstant.getName()));
					}
				}
				listValues = new AllowableListValues(list, enumClass.getName());
			} else {
				listValues = new AllowableListValues(
						Arrays.stream(enumConstants)
								.map(t ->
										getPair(t.getValue(), t.getName()))
								.collect(Collectors.toList()),
						enumClass.getName());
			}
			propertyBuilder.allowEmptyValue(false);
			propertyBuilder.enumerationFacet(builder -> builder.allowedValues(listValues));
		}
	}

	private String getPair(Object code, Object name) {
		return code + ":" + name;
	}

	@Override
	public boolean supports(DocumentationType documentationType) {
		return true;
	}

}

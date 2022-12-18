
package com.yyn.sharing.knowledge.annotation;

import com.yyn.sharing.knowledge.enums.*;

import java.lang.annotation.*;

@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface ApiModelEnumProperty {
	String value() default "";

	String[] values() default {};

	Class<? extends Enum<? extends NameValueEnum<?, ?>>> enumClass() default DefaultEnum.class;

	boolean required() default false;

	String description() default "";
}

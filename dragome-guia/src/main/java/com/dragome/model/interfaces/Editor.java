/*
 * Copyright (c) 2011-2014 Fernando Petrola
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dragome.model.interfaces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface Editor<T>
{
	/**
	 * Tells the Editor framework to ignore an Editor accessor.
	 */
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(value= { ElementType.FIELD, ElementType.METHOD })
	public @interface Ignore
	{
	}

	/**
	 * Maps a composite Editor's component Editors into the data-model.
	 */
	@Documented
	@Retention(RetentionPolicy.RUNTIME)
	@Target(value= { ElementType.FIELD, ElementType.METHOD })
	public @interface Path
	{
		String value();
	}
}

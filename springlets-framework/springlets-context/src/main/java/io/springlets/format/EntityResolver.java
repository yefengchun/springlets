/*
 * Copyright 2016 the original author or authors.
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
package io.springlets.format;

/**
 * Resolver of entities through its identifier.
 * @author Cèsar Ordiñana at http://www.disid.com[DISID Corporation S.L.]
 */
public interface EntityResolver<T, ID> {

  /**
   * Retrieves an entity by its id.
   * 
   * @param id must not be {@literal null}.
   * @return the entity with the given id or {@literal null} if none found
   * @throws IllegalArgumentException if {@code id} is {@literal null}
   */
  T findOne(ID id);

  /**
   * Returns the class of the entities resolved by this {@link EntityResolver}. 
   * @return the entities class
   */
  Class<T> getEntityType();

  /**
   * Returns the class of the identifier of the entities resolved by this {@link EntityResolver}.
   * @return the identifier class
   */
  Class<ID> getIdType();

}

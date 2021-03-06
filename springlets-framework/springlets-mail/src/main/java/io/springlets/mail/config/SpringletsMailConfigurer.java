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
package io.springlets.mail.config;

/**
 * Component to configure and customize the setup of Springlets Mail.
 *
 * @author Manuel Iborra at http://www.disid.com[DISID Corporation S.L.]
 */
public interface SpringletsMailConfigurer {

  /**
   * Adds additional configuration to the given SpringletsMailSettings.
   *
   * @param config Main configuration bean.
   */
  void configureSpringletsMailSettings(SpringletsMailSettings config);

}

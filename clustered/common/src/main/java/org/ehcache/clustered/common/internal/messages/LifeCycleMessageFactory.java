/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehcache.clustered.common.internal.messages;

import org.ehcache.clustered.common.ServerSideConfiguration;
import org.ehcache.clustered.common.internal.ServerStoreConfiguration;

import java.util.UUID;

public class LifeCycleMessageFactory {

  private UUID clientId;

  public EhcacheEntityMessage validateStoreManager(ServerSideConfiguration configuration){
    return new LifecycleMessage.ValidateStoreManager(configuration, clientId);
  }

  public EhcacheEntityMessage configureStoreManager(ServerSideConfiguration configuration) {
    return new LifecycleMessage.ConfigureStoreManager(configuration, clientId);
  }

  public EhcacheEntityMessage createServerStore(String name, ServerStoreConfiguration serverStoreConfiguration) {
    return new LifecycleMessage.CreateServerStore(name, serverStoreConfiguration, clientId);
  }

  public EhcacheEntityMessage validateServerStore(String name, ServerStoreConfiguration serverStoreConfiguration) {
    return new LifecycleMessage.ValidateServerStore(name, serverStoreConfiguration, clientId);
  }

  public EhcacheEntityMessage releaseServerStore(String name) {
    return new LifecycleMessage.ReleaseServerStore(name, clientId);
  }

  public EhcacheEntityMessage destroyServerStore(String name) {
    return new LifecycleMessage.DestroyServerStore(name, clientId);
  }

  public void setClientId(UUID clientId) {
    this.clientId = clientId;
  }
}

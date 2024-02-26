/*
 * Copyright 2023 Aiven Oy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.aiven.kafka.tieredstorage.storage;

import java.util.Set;

public interface ObjectDeleter {
    /**
     * Delete the object with the specified key.
     *
     * <p>If the object doesn't exist, the operation still succeeds as it is idempotent.
     */
    void delete(ObjectKey key) throws StorageBackendException;

    /**
     * Delete objects from a set of keys.
     *
     * <p>If the object doesn't exist, the operation still succeeds as it is idempotent.
     */
    default void delete(Set<ObjectKey> keys) throws StorageBackendException {
        for (final var key : keys) {
            delete(key);
        }
    }
}

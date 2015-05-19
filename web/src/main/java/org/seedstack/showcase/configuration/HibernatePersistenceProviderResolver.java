/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.showcase.configuration;

import java.util.Collections;
import java.util.List;

import javax.persistence.spi.PersistenceProvider;
import javax.persistence.spi.PersistenceProviderResolver;
import javax.persistence.spi.PersistenceProviderResolverHolder;

import org.hibernate.ejb.HibernatePersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernatePersistenceProviderResolver implements PersistenceProviderResolver {

 private static Logger logger = LoggerFactory.getLogger(HibernatePersistenceProviderResolver.class);

 private volatile PersistenceProvider persistenceProvider = new HibernatePersistence();

 @Override
 public List<PersistenceProvider> getPersistenceProviders() {
  return Collections.singletonList(persistenceProvider);
 }

 @Override
 public void clearCachedProviders() {
  persistenceProvider = new HibernatePersistence();

 }

 public static void register() {
  logger.info("Registering HibernatePersistenceProviderResolver");
  PersistenceProviderResolverHolder.setPersistenceProviderResolver(new HibernatePersistenceProviderResolver());
 }
}
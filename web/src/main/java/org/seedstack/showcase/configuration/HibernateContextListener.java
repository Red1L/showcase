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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateContextListener implements ServletContextListener {

 private static Logger logger = LoggerFactory.getLogger(HibernateContextListener.class);

 public void contextInitialized(ServletContextEvent sce) {
  logger.debug("context initialised");
  HibernatePersistenceProviderResolver.register();
 }

 public void contextDestroyed(ServletContextEvent sce) {
  logger.debug("context destroyed");

 }

}
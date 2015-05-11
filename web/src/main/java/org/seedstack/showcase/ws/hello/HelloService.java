/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.showcase.ws.hello;

import org.seedstack.ws.hello.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebService;

@WebService(endpointInterface = "org.seedstack.ws.hello.Hello", targetNamespace = "http://seedstack.org/wsdl/seed/hello/", serviceName = "HelloService", portName = "HelloServicePort")
public class HelloService implements Hello {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

    @Override
    public void sayHello(String hello) {
        LOGGER.error("==================    " + hello + "    ==================");
    }

}

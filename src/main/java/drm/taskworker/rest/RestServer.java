/*
    Copyright 2013 KU Leuven Research and Development - iMinds - Distrinet

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

    Administrative Contact: dnet-project-office@cs.kuleuven.be
    Technical Contact: bart.vanbrabant@cs.kuleuven.be
*/

package drm.taskworker.rest;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import static drm.taskworker.config.Config.cfg;

public class RestServer {
	private HttpServer server = null;
	public RestServer() {
		
	}
	
	public void start() {
        // create a resource config that scans for JAX-RS resources and providers
        // in drm.taskwork.rest package
        final ResourceConfig rc = new ResourceConfig().packages("drm.taskworker.rest");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
         server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}
	
	public void stop() {
		server.stop();
	}
	
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://" + cfg().getProperty("taskworker.rest.ip", "localhost") 
            + ":" + cfg().getProperty("taskworker.rest.port", 8123) + "/";

}

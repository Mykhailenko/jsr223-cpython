/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package EntryPoint;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Collection;

import javax.script.Bindings;

import py4j.GatewayServer;

/**
 * @author ActiveEon Team
 * @since 05/10/2017
 */
public class EntryPoint {
    /**
     * Singleton
     */
    private static EntryPoint ourInstance = new EntryPoint();

    private EntryPoint() {}

    public static EntryPoint getInstance() {
        return ourInstance;
    }

    private Map<String, Serializable> variabels = new HashMap<>();

    private Bindings bindings = new Bindings() {
        @Override
        public Object put(String name, Object value) {
            return null;
        }

        @Override
        public void putAll(Map<? extends String, ?> toMerge) {

        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public Object get(Object key) {
            return null;
        }

        @Override
        public Object remove(Object key) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Set<String> keySet() {
            return null;
        }

        @Override
        public Collection<Object> values() {
            return null;
        }

        @Override
        public Set<Entry<String, Object>> entrySet() {
            return null;
        }
    };

    //Add the objects to the gateway server
    //TODO not sure we still need this getVariables() because we already have the getBindings() whtich contains all
    public Map getVariables(){
        return variabels;
    }

    public Bindings getBindings() {
        return bindings;
    }

    //Start gateway server
    public void gateWayServerStart(){
        GatewayServer gatewayServer = new GatewayServer(this.getInstance());
        gatewayServer.start();
        System.out.println("GateWay Server Started");
    }

    //Stop gateway server
    public void gateWayServerStop(){
        GatewayServer gatewayServer = new GatewayServer(this.getInstance());
        gatewayServer.shutdown();
        System.out.println("GateWay Server Stopped");
    }

}

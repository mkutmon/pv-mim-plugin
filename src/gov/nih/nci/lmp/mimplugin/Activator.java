package gov.nih.nci.lmp.mimplugin;

//
// Licensed under the Apache License, Version 2.0 (the "License"); 
// you may not use this file except in compliance with the License. 
// You may obtain a copy of the License at 
// 
// http://www.apache.org/licenses/LICENSE-2.0 
//  
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, 
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
// See the License for the specific language governing permissions and 
// limitations under the License.
//

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.pathvisio.desktop.plugin.Plugin;

/**
 * Activator class to register the MIM plugin as OSGi service
 * 
 * @author Martina Summer-Kutmon
 * 
 * @version 2.0.0
 * @since 2.0.0
 * 
 */
public class Activator implements BundleActivator {

	private MimPlugin plugin;
	
	@Override
	public void start(BundleContext context) throws Exception {
		plugin = new MimPlugin();
		context.registerService(Plugin.class.getName(), plugin, null);
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		plugin.done();
	}

}

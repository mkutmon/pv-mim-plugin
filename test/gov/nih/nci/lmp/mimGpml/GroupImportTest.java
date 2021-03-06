/**
 * The information, opinions, data, and statements contained herein are not 
 * necessarily those of the U.S. Government or the National Institutes of Health (NIH) 
 * and should not be interpreted, acted on, or represented as such.
 * 
 * Reference herein to any specific commercial product, process, or service by 
 * trade name, trademark, manufacturer, or otherwise, does not necessarily 
 * constitute or imply its endorsement, recommendation, or favoring by the U.S. 
 * Government, NIH, or any of their employees and contractors.
 * 
 * The U.S. Government, NIH and their employees and contractors do not make 
 * any warranty, express or implied, including the warranties of merchantability 
 * and fitness for a particular purpose with respect to this document. In addition, 
 * the U.S. Government, NIH, and their employees and contractors assume no legal 
 * liability for the accuracy, completeness, or usefulness of any information, 
 * apparatus, product, or process disclosed herein and do not represent that use 
 * of such information, apparatus, product or process would not infringe on 
 * privately owned rights.
 * 
 * This document is sponsored by the NIH, along with private companies and other 
 * organizations. Accordingly, other parties may retain all rights to publish or 
 * reproduce these documents or to allow others to do so. This document may be 
 * protected under the U.S. and foreign Copyright laws. 
 * 
 * Permission to reproduce may be required.
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
 *
 */
package gov.nih.nci.lmp.mimGpml;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.pathvisio.core.debug.Logger;
import org.pathvisio.core.model.ConverterException;
import org.pathvisio.core.model.Pathway;
import org.pathvisio.core.model.PathwayElement;
import org.pathvisio.core.view.MIMShapes;

/**
 * Test for the import of groups from MIMML. 
 * 
 * @author Augustin Luna <augustin@mail.nih.gov>
 * 
 */
public class GroupImportTest {

	/** The Constant DIR. */
	private static final File DIR = new File("resources");

	/** The Constant TEST_FILE. */
	private static final File TEST_FILE = new File(DIR, "groupTest.mimml");

	/** The pathway. */
	private Pathway pw; 
	
	/**
	 * Sets the up.
	 * 
	 * @throws ConverterException
	 *             the converter exception
	 */
	@Before
	public void setUp() throws ConverterException {
		MIMShapes.registerShapes();

		ImporterHelper helper = new ImporterHelper(TEST_FILE);
		pw = helper.getPw();
	}

	@Test
	public void testPathwayGroupGraphIdImport() {
		Logger.log.debug("Group Ids: " + pw.getGroupIds().toString());
		
		PathwayElement pwElem = pw.getGroupById("c984b");

		assertEquals("c984b", pwElem.getGroupId());
	}

	@Test
	@Ignore("Requires the non-MIMML part of the plugin to set the GroupStyle")
	public void testPathwayGroupStyleComplexImport() {
		PathwayElement pwElem = pw.getGroupById("c984b");

		assertEquals("ImplicitComplex", pwElem.getGroupStyle().toString());
	}

	@Test
	public void testPathwayGroupStyleGroupImport() {
		PathwayElement pwElem = pw.getGroupById("e5a14");

		assertEquals("Group", pwElem.getGroupStyle().toString());
	}
}

package de.schauderhaft.degraph.gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import org.junit.Before;
import org.junit.Test;

import de.schauderhaft.degraph.java.JavaHierarchicGraph;

public class MainViewControllerTest {

	private MainViewController underTest;
	private final JavaHierarchicGraph graph = SampleGraph.getChessgraph();

	@Before
	public void init() {
		underTest = new MainViewController(getGraph());
	}

	private JavaHierarchicGraph getGraph() {
		return graph;
	}

	@Test
	public void paneShouldHaveContent() {
		assertNotNull(underTest.getContent());
	}

	@Test
	public void contentShouldBeAnchorPane() {
		Node content = underTest.getContent();
		assertEquals(AnchorPane.class, content.getClass());
	}

}
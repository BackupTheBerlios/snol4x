package de.fractalqb.snol4x

import org.scalatest.junit.JUnitRunner
import org.scalatest.junit.AssertionsForJUnit
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class FacetSuite extends AssertionsForJUnit {

	@Test
	def facetCreation {
		val someFacte = Facet( "some-facet" )
	}
}
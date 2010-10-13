package de.fractalqb.snol4x

import org.scalatest.junit.JUnit3Suite

class FacetSuite extends JUnit3Suite {

	def testFacetCreation {
		val someFacte = Facet( "some-facet" )
		Facet.all.foreach( f => println( f.name ) )
	}
}

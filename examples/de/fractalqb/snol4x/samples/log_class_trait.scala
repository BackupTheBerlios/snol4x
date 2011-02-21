package de.fractalqb.snol4x.samples

import de.fractalqb.snol4x._

object SomeClass extends StdLogging {
	override val componentPath = StdLogging.pathFor[SomeClass]
	
	def main( args: Array[String] ) {
		val instance = new SomeClass
		instance.fun()
	}
	
	private var funCounter = 0
}

class SomeClass {
	import SomeClass.LOGdebug
	val trace = SomeClass.LOGtrace( Priority NORMAL )_
	def fun() {
		SomeClass.funCounter += 1
		trace( "fun(%2$d) was called %1$d times", SomeClass.funCounter, 42 )
		LOGdebug( Priority IRRELEVANT )( "There's nothing to debug, here!" )
	}
}

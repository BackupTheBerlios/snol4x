package de.fractalqb.snol4x

abstract class Channel extends Equals {
	def send( cats: Seq[Category], timestamp: Long, form: String, args: Array[Any] ): Unit
	
	override def canEqual( that: Any ): Boolean = that match {
		case r: AnyRef => this.getClass == r.getClass
		case _ => false
	}
}

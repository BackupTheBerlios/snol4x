package de.fractalqb.snol4x

abstract class Channel {
	def send( cats: Seq[Category], timestamp: Long, form: String, args: Array[Any] ): Unit
}

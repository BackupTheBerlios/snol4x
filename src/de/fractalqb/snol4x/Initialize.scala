package de.fractalqb.snol4x

trait Initialize
{
	def initialize(): Unit
}

class DefaultInit extends Initialize
{
	override def initialize() {
		Facet.TOPIC += PrintStreamChannel.ERR
	}
}

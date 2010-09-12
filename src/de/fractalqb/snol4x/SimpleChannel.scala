package de.fractalqb.snol4x

object SimpleChannel extends Channel {
	override def send( cats: Seq[Category], timestamp: Long, form: String, args: Array[Any] ) {
		System.err.append( timestamp.toString ).append( ':' )
		cats.foreach { c => System.err.append( '[' + c.path + ']' ) }
		System.err.append( ':' ).append( form ).println( args.mkString( "{", ";", "}" ) )
	}
}

package de.fractalqb.snol4x

import java.text.SimpleDateFormat
import java.io.PrintStream

object PrintStreamChannel
{
	lazy val OUT = new PrintStreamChannel( System.out, BasicFormat )
	lazy val ERR = new PrintStreamChannel( System.err, BasicFormat )
	
	abstract class Format {
		def apply( os: PrintStream,
				   cats: Seq[Category],
				   timestamp: Long,
				   prio: Short,
				   form: String,
				   args: Array[Any] )
	}
}


object BasicFormat extends PrintStreamChannel.Format
{
	private val dtfm = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" )

	def apply( os: PrintStream,
			   cats: Seq[Category],
			   timestamp: Long,
			   prio: Short,
			   form: String,
			   args: Array[Any] )
	{
		os.append( dtfm.format( timestamp ) ).append( '!' )
		  .append( prio.toString ).append( ':' )
		cats.foreach { c => os.append( '[' + c.path + ']' ) }
		os.append( ':' ).append( form.format( args: _* ) ).println			
	}
}


class PrintStreamChannel( val os: PrintStream,
		                  var fmt: PrintStreamChannel.Format )
    extends Channel
{
	override def send( cats: Seq[Category],
			           timestamp: Long,
			           prio: Short,
			           form: String,
			           args: Array[Any] )
	{
		fmt( os, cats, timestamp, prio, form, args )
	}
	
	override def equals( that: Any ): Boolean = that match {
		case psc: PrintStreamChannel => this.os == psc.os
		case _ => false
	}
}

package de.fractalqb.snol4x

import scala.collection.immutable.SortedSet

abstract class Category( val name: String,
						 var prioThreshold: Short )
  extends Equals
{
  private var subs: Set[SubCategory] = SortedSet.empty[SubCategory] {
	new Ordering[SubCategory] {
		override def compare( sc1: SubCategory, sc2: SubCategory ): Int =
			sc1.name compare sc2.name
	}
  }
  
  private[snol4x] var logrs = Set.empty[Logger]
  private var chans = Set.empty[Channel]

  def path: String
  def facet: Facet

  def has( name: String ): Option[SubCategory] =
	subs.find( _.name == name )

  def get( name: String ): SubCategory =
	has( name ) match {
	  case Some(cat) => cat
	  case None => {
		val cat = new SubCategory( this, name )
		subs += cat
		cat
	  }
	}

  def apply( path: Seq[String] ): Category =
	(this /: path) { (c, n) => c.get( n ) }

  def apply( pathStr: String, sep: String = "\\." ): Category =
	this( pathStr split sep )

  def channels = chans
	
  def += ( channel: Channel ) = { chans += channel; this }
  def -= ( channel: Channel ) = { chans -= channel; this }
  
  def reconfigure() {
	  subs.foreach( _.reconfigure() )
	  logrs.foreach( _.reconf() )
  }
  
  override def canEqual( that: Any ): Boolean =
	that.isInstanceOf[Category]
}

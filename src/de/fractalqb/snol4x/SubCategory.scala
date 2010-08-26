package de.fractalqb.snol4x

class SubCategory( val parent: Category,
				   name: String )
  extends Category( name, parent.prioThrh )
{
  override def path: String = 
	if ( parent.isInstanceOf[Facet] )
	  parent.name + ':' ++ name
	else
	  parent.path + '.' ++ name

  override def facet: Facet = parent.facet
}

package de.fractalqb.snol4x

object Priority
{
	def MOST_IMPORTANT: Short = Short.MaxValue
	def IMPORTANT: Short = (MOST_IMPORTANT / 2).asInstanceOf[Short]
	def NORMAL: Short = 0
	def IRRELEVANT: Short = Short.MinValue
	def UNIMPORTANT: Short = (-IMPORTANT).asInstanceOf[Short] 
}
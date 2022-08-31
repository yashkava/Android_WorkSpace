fun main()
{
    println("ENTER YOUR MARKS :  ")
    val marks= readLine()!!.toInt()



    if(marks>=70)
    {
     println("A Grade")
    }
    else if(marks>=60)
    {
     println("B Grade")
    }
    else if(marks>=50)
    {
     println("C Grade")
    }
    else
    {
     println("Fail")
    }
}
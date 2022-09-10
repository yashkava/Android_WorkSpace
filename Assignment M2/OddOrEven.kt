fun main()
{
    print("ENTER NUMBER: ")
    val num = readLine()!!.toInt()

    if (num % 2 == 0)
        println("$num IS EVEN NUMBER")
    else
        println("$num IS ODD NUMBER")
}
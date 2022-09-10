fun main()
{
    val str = "TOPS TECHNOLOGIES"
    val ch = 'O'
    var a = 0

    for (i in 0..str.length - 1)
    {
        if (ch == str[i])
        {
            a++
        }
    }

    println("Frequency of $ch = $a")
}
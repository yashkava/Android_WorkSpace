fun main()
{

    var myMap = HashMap<String,String>()
    myMap.put("GUJARAT","RAJKOT")
    myMap.put("MAHARASHTRA","PUNE")
    myMap.put("PUNJAB","AMRITSAR")


    for(key in myMap.keys)
    {
        println("Element at key : $key = ${myMap[key]}")
    }
}
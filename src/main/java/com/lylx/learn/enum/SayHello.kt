
/**
 * 枚举类
 */
enum class Language(val hello: String) {
    ENGLISH("Hello"),
    CHINESE("你好"),
    JAPANESE("こんにちは"),
    KOREAN("안녕하새요");

    fun sayHello(){
        println(hello)
    }

    /**
     * 伴生对象：定义类似于java里面静态方法、静态变量、静态常量的地方
     */
    companion object {
        fun parse(name: String): Language {
            return Language.valueOf(name.toUpperCase())
        }
    }

    /**
     * 构造方法init
     */
}

fun main(args: Array<String>) {
    if (args.isEmpty()) return
    val language = Language.parse(args[0])
    println(language)
    language.sayHello()
    language.sayBye()
}

/**
 * kotlin的扩展方法
 *
 * kotlin的when类似于java的switch ，但是kotlin的when有返回值，使用更灵活
 */
fun Language.sayBye(){
    val bye = when(this){
        Language.ENGLISH ->"Bye"
        Language.CHINESE ->"再见"
        Language.JAPANESE ->"さようなら"
        Language.KOREAN -> "안녕히가세요"
    }
    println(bye)
}
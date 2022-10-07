package kotlinx.atomicfu.transformer

import org.junit.Test
import java.io.File

/**
 * Created by benny.
 */
class AtomicFUTransformerTest {

    @Test
    fun test() {
        val transformer = AtomicFUTransformer(
            emptyList(),
            File("../atomicfu-testdata/build/classes/kotlin/jvm/main").also {
                println(it.absoluteFile)
            },
            File("../atomicfu-testdata/build/atomicFU/jvm"),
        )
        transformer.transform()
    }
}
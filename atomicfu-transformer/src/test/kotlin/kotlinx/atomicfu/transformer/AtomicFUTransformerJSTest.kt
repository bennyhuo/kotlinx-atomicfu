package kotlinx.atomicfu.transformer

import org.junit.Test
import java.io.File

/**
 * Created by benny.
 */
class AtomicFUTransformerJSTest {

    @Test
    fun test() {
        val transformer = AtomicFUTransformerJS(
            File("../build/js/packages/kotlinx.atomicfu-atomicfu-testdata/kotlin"),
            File("../atomicfu-testdata/build/atomicFUJS/"),
        )
        transformer.transform()
    }
}
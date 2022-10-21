package util

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.NumberFormatException

class KBInput {

    companion object {
        private fun getBufferedReader(): BufferedReader {
            return BufferedReader(
                InputStreamReader(System.`in`)
            )
        }

        fun readString(prompt:String):String? {
            print(prompt)
            return try {
                return getBufferedReader().readLine()
            } catch(ioExc:IOException) {
                System.err.println(ioExc.message)
                null
            }
        }

        fun readInteger(prompt:String):Int? {
            print(prompt)
            return try {
                getBufferedReader().readLine().toInt()
            } catch (ioExc: IOException) {
                System.err.println(ioExc.message)
                null
            } catch (nfExc: NumberFormatException) {
                System.err.println(nfExc.message)
                null
            }
        }

        fun readDouble(prompt:String):Double? {
            print(prompt)
            return try {
                getBufferedReader().readLine().toDouble()
            } catch (ioExc: IOException) {
                System.err.println(ioExc.message)
                null
            } catch (nfExc: NumberFormatException) {
                System.err.println(nfExc.message)
                null
            }

        }
    }
}
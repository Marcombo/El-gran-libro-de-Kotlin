package marcombo.lcriadof.capitulo7.fichero.zip

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream


class ficheroZip(var url:String) {

    // comprime solo una agrupación de ficheros concreta
    fun comprimir(fichZipOut:String,vararg fichOrigen:String){ // [1]
        var file:File  // [2]
        var entry: ZipEntry // [3]
        var ops = ZipOutputStream(FileOutputStream( url+fichZipOut )) // [4]

        for (fichin in fichOrigen){ // [5]
            file = File(url+fichin) // [6]
            entry = ZipEntry(url+fichin) // [7]
            try {
                val buf = ByteArray(1024) // [8]
                ops.putNextEntry(entry) // [9]
                ops.setComment("fichero "+fichin) // [10]

                // [11] inicio del BLOQUE QUE COMPRIME UNA ENTRADA
                val fis = FileInputStream(file)
                var len: Int
                while (fis.read(buf).also { len = it } > 0) {  // [12]
                    ops.write(buf, 0, len)
                }
                fis.close()
                ops.closeEntry()
                // [13] fin del BLOQUE

            } catch (e: IOException) {
                // en caso de error ejecutar este código
                e.printStackTrace()
            }

        } // fin de for
        ops.flush()
        ops.close()
    }




    // comprime un directorio completo con todo su contenido solo al primer nivel
    fun comprimir(fichZipOut:String){
        var entry: ZipEntry
        var ops = ZipOutputStream(FileOutputStream( url+fichZipOut ))
        val buf = ByteArray(1024)


        File(url).walkTopDown().forEach { // [14]
            entry = ZipEntry(it.name)
            println(it.name)

            if (it.isFile and !it.extension.equals("zip")){
                ops.putNextEntry(entry) // [15]
                ops.setComment("fichero "+it) // [16]

                val fis = FileInputStream(it)
                var len: Int
                while (fis.read(buf).also { len = it } > 0) {  // [17]
                    ops.write(buf, 0, len)
                }
                fis.close()
                ops.closeEntry()
            }

         }
        ops.flush()
        ops.close()
    }



    fun descomprimir(){
        var nombreFicheroZip: String = ""

        File(url).walkTopDown().forEach { // [18]  // recorremos todo el directorio y descomprimimos los zip
            nombreFicheroZip = it.canonicalFile.toString()
            if (it.isFile and it.extension.equals("zip")) { // [19]
                println("Fichero zip encontrado: "+it)
                ZipFile(nombreFicheroZip).use { zip ->
                    zip.entries().asSequence().forEach { entrada -> // [20]
                            if (entrada.isDirectory){ // [21]
                               val nuevoPath: String = url+entrada.name
                               println(".....directorio creado: "+nuevoPath)
                               File(nuevoPath).mkdirs() // [22]
                            } else{ // [23]
                                zip.getInputStream(entrada).use {
                                        input ->
                                    println(".....descomprimiendo "+File(url+entrada.name).canonicalFile)
                                    File(url+entrada.name).outputStream().use { output -> input.copyTo(output) } // [24]
                                }
                            }
                    }


                } // fin de ZipFile
            } // fin de if
        } // fin de descomprimir
    } // fin de método


    fun descomprimir(entradaAdescomprimir:String){
        var nombreFicheroZip: String = ""

        File(url).walkTopDown().forEach {
            nombreFicheroZip = it.canonicalFile.toString()
            if (it.isFile and it.extension.equals("zip")) {
                println("Fichero zip encontrado: "+it)
                ZipFile(nombreFicheroZip).use { zip ->
                    zip.entries().asSequence().forEach {entrada ->
                        //println("  "+File(entrada.name)+" + "+entradaAdescomprimir)
                        //println(entrada.name.substringAfterLast("/"))
                        if (entrada.isDirectory){
                            val nuevoPath: String = url+entrada.name
                            //println(".....directorio creado: "+nuevoPath)
                            File(nuevoPath).mkdirs()
                        } else{
                            if (entrada.name.substringAfterLast("/").equals(entradaAdescomprimir)){  // [25]
                                zip.getInputStream(entrada).use {
                                    input ->
                                println(".....descomprimiendo "+File(url+entrada.name).canonicalFile)
                                File(url+entrada.name).outputStream().use { output -> input.copyTo(output) }
                                }
                            }
                        }
                    }
                } // fin de ZipFile
            } // fin de if
        } // fin de descomprimir
    } // fin de método



    fun listaFicherosComprimidos(){
        var nombreFicheroZip: String = ""

        File(url).walkTopDown().forEach {
            nombreFicheroZip = it.canonicalFile.toString()
            if (it.isFile and it.extension.equals("zip")) {
                println("Fichero zip encontrado: "+it)

                ZipFile(nombreFicheroZip).use { zip ->
                    zip.entries().asSequence().forEach { // [26]
                        println("     entrada loclizada en zip: "+it)

                    }


                } // fin de ZipFile
            } // fin de if
        } // fin de descomprimir
    } // fin de método




} // fin de clase
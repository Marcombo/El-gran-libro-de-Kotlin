package marcombo.lcriadof.capitulo7.fichero.zip

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream


class ficheroZip(var url:String) {

    // comprime solo una lista de ficheros concreta
    fun comprimir(fichZipOut:String,vararg fichOrigen:String){ // [1]
        var file:File  // [2]
        var entry: ZipEntry // [3]
        var ops = ZipOutputStream(FileOutputStream( url+fichZipOut )) // [4]

        for (fichin in fichOrigen){ // [5]
            file = File(url+fichin) // [6]
            entry = ZipEntry(url+fichin) // [7]
            try {
                val buf = ByteArray(1024) // [8]
                ops.putNextEntry(entry) // [9] Coloca el objeto en el documento comprimido
                ops.setComment("fichero "+fichin) // [10]  Crear un comentario de documento

                // [11] BLOQUE QUE COMPRIME UNA ENTRADA
                val fis = FileInputStream(file)
                var len: Int
                while (fis.read(buf).also { len = it } > 0) {  // [12] copiamos con bloques determinados por "buf" del fichero origen al flujo zip
                    ops.write(buf, 0, len)
                }
                fis.close()
                ops.closeEntry()
                // FIN DEL bloque

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


        File(url).walkTopDown().forEach { // [13] recorremos todo el directorio
            entry = ZipEntry(it.name)
            println(it.name)

            if (it.isFile and !it.extension.equals("zip")){
                ops.putNextEntry(entry) // Coloca el objeto en el documento comprimido
                ops.setComment("fichero "+it) // Crear un comentario de documento

                val fis = FileInputStream(it)
                var len: Int
                while (fis.read(buf).also { len = it } > 0) {  // copiamos con bloques determinados por "buf" del fichero origen al flujo zip
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

        File(url).walkTopDown().forEach { // [14]  // recorremos todo el directorio y descomprimimos los zip
            nombreFicheroZip = it.canonicalFile.toString()
            if (it.isFile and it.extension.equals("zip")) { // [15]
                println("Fichero zip encontrado: "+it)
                ZipFile(nombreFicheroZip).use { zip -> // [16]
                    zip.entries().asSequence().forEach { entrada -> // [17]
                            if (entrada.isDirectory){ // [18] si la entrada es un directorio: lo creamos para replicar la extructura comprimida
                               val nuevoPath: String = url+entrada.name
                               println(".....directorio creado: "+nuevoPath)
                               File(nuevoPath).mkdirs()
                            } else{ // [19] si la entrada es un fichero: descomprimimos
                                zip.getInputStream(entrada).use {
                                        input ->
                                    println(".....descomprimiendo "+File(url+entrada.name).canonicalFile)
                                    File(url+entrada.name).outputStream().use { output -> input.copyTo(output) } // [20]
                                }
                            }
                    }


                } // fin de ZipFile
            } // fin de if
        } // fin de descomprimir
    } // fin de método




} // fin de clase
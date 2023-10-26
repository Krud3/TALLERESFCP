import SubsecuenciaMasLarga._
hello
bye 
bye 

subindices(2, 3)
subindices(0, 3)

subindices(1, 5)//HashSet(List(1), List(1, 2, 3), List(1, 3), List(3), List(), List(2, 3), List(1, 4), List(1, 3, 4), List(1, 2), List(2, 3, 4), List(3, 4), List(4), List(2), List(2, 4), List(1, 2, 3, 4), List(1, 2, 4))
subindices(3, 6)//HashSet(List(4, 5), List(3), List(), List(3, 5), List(5), List(3, 4, 5), List(3, 4), List(4))
subindices(0, 4)//HashSet(List(1, 2, 3), List(0, 1, 2, 3), List(0, 3), List(3), List(2, 3), List(0, 1), List(1, 2), List(0, 2), List(0), List(2), List(0, 1, 3), List(1), List(1, 3), List(0, 2, 3), List(0, 1, 2), List())
subindices(2, 7)//HashSet(List(3, 5, 6), List(2, 3, 5, 6), List(5, 6), List(4, 5), List(), List(2, 3), List(2, 3, 5), List(3, 5), List(3, 6), List(3, 4), List(2, 3, 6), List(2), List(2, 4), List(4, 6), List(2, 4, 5), List(2, 3, 4, 5), List(2, 3, 4, 5, 6), List(3), List(3, 4, 5, 6), List(2, 3, 4, 6), List(2, 5, 6), List(4, 5, 6), List(5), List(6), List(2, 4, 6), List(3, 4, 6), List(3, 4, 5), List(2, 3, 4), List(2, 5), List(2, 6), List(2, 4, 5, 6), List(4))
subindices(4, 8)//HashSet(List(4, 5, 7), List(4, 6, 7), List(5, 6), List(4, 5), List(), List(5, 7), List(4, 5, 6), List(6, 7), List(4), List(5, 6, 7), List(4, 7), List(4, 5, 6, 7), List(4, 6), List(7), List(5), List(6))




val s = Seq(20,30,10,40,15,16,17)
subSecuenciaAsoc(s, Seq())
subSecuenciaAsoc(s, Seq(0,2,4))
subSecuenciaAsoc(s, Seq(1,2,4,6))

val s1 = Seq(5, 25, 35, 45, 55, 65, 75)
subSecuenciaAsoc(s1, Seq()) //List()
subSecuenciaAsoc(s1, Seq(0, 2, 4)) //List(5, 35, 55)
subSecuenciaAsoc(s1, Seq(1, 2, 4, 6)) //List(25, 35, 55, 75)
subSecuenciaAsoc(s1, Seq(0, 3, 5)) //List(5, 45, 65)
subSecuenciaAsoc(s1, Seq(2, 3, 4, 5)) //List(35, 45, 55, 65)

val s20 =Seq(20,30,10)
subSecuenciasDe(s20)

val s2 = Seq(20, 30, 10) 
subSecuenciasDe(s2)  //HashSet(List(30), List(20, 30, 10), List(30, 10), List(20), List(10), List(20, 30), List(20, 10), List())
val s3 = Seq(10, 20)
subSecuenciasDe(s3)  //Set(List(), List(10), List(20), List(10, 20))
val s4 = Seq(5, 15, 25, 35)
subSecuenciasDe(s4)  //HashSet(List(5, 15, 25, 35), List(), List(5, 15, 35), List(15, 35), List(5, 25, 35), List(15, 25, 35), List(25), List(35), List(15, 25), List(15), List(5, 35), List(5, 15), List(5), List(25, 35), List(5, 25), List(5, 15, 25))
val s5 = Seq(1, 2, 3, 4, 5)
subSecuenciasDe(s5)  //HashSet(List(1), List(1, 2, 3), List(1, 3), List(3, 4), List(4), List(2), List(1, 2, 3, 4), List(1, 2, 4), List(1, 2, 3, 4, 5), List(1, 2, 3, 5), List(1, 4, 5), List(4, 5), List(1, 3, 4, 5), List(2, 4, 5), List(2, 3, 4, 5), List(3), List(1, 5), List(), List(1, 2, 4, 5), List(2, 3), List(2, 3, 5), List(1, 4), List(1, 3, 4), List(3, 5), List(1, 2), List(1, 2, 5), List(5), List(3, 4, 5), List(2, 3, 4), List(2, 5), List(1, 3, 5), List(2, 4))
val s6 = Seq(50, 60, 70, 80, 90, 100)
subSecuenciasDe(s6) //HashSet(List(50, 60, 70), List(70), List(60, 80, 90), List(50, 60, 80, 90, 100), List(50, 70), List(60, 70, 80), List(100), List(50, 90, 100), List(50, 60, 90), List(90), List(60, 100), List(80, 90, 100), List(60, 70, 100), List(50, 80, 100), List(70, 100), List(50, 60, 70, 90, 100), List(50, 80, 90, 100), List(50, 60), List(50, 100), List(50, 70, 80, 90), List(50, 60, 100), List(50, 70, 90, 100), List(50, 60, 70, 80, 100), List(60, 70, 80, 90), List(60, 80), List(80, 100), List(70, 90, 100), List(50, 70, 80, 100), List(60, 70, 90, 100), List(60, 90), List(60, 80, 90, 100), List(50, 70, 100), List(80), List(60, 90, 100), List(), List(50, 60, 70, 90), List(50, 60, 70, 80, 90, 100), List(70, 80, 90, 100), List(50, 60, 80, 100), List(50, 60, 80), List(80, 90), List(60, 70, 80, 100), List(60, 70), List(50, 70, 80, 90, 100), List(90, 100), List(70, 80, 100), List(60, 80, 100), List(50, 70, 80), List(50, 80), List(60, 70, 90), List(50, 60, 
 // 70, 80, 90), List(70, 90), List(60, 70, 80, 90, 100), List(50, 80, 90), List(50), List(60), List(50, 60, 80, 90), List(70, 80), List(50, 90), List(50, 60, 70, 80), List(50, 60, 70, 100), List(50, 60, 90, 100), List(50, 70, 90), List(70, 80, 90))

val s7 = Seq(1, 2, 3, 4, 5, 6, 7)
incremental(s7)// true
val s8 = Seq()
incremental(s8)//true
val s9 = Seq(1, 1, 1, 1, 1, 1, 1)
incremental(s9)//false
val s10 = Seq(1, 2, 3, 5, 4, 6, 7)
incremental(s10)//false
val s11 = Seq(7, 6, 5, 4, 3, 2, 1)
incremental(s11)//false


subSecuenciasInc(Seq(20, 30, 10, 40, 15, 16, 17))
subSecuenciasInc(Seq(20, 30, 10))

subSecuenciasInc(Seq(1, 2)) //Set(List(), List(1), List(2), List(1, 2))
subSecuenciasInc(Seq(5, 7, 9)) //HashSet(List(5, 9), List(9), List(7), List(), List(5, 7), List(7, 9), List(5, 7, 9), List(5))
subSecuenciasInc(Seq(2, 4, 8, 16)) //HashSet(List(8), List(16), List(4, 16), List(2, 8), List(2, 4, 16), List(4), List(2, 16), List(2, 8, 16), List(8, 16), List(4, 8, 16), List(), List(2), List(2, 4, 8, 16), List(4, 8), List(2, 4), List(2, 4, 8))
subSecuenciasInc(Seq(0, 1, 2)) //HashSet(List(1), List(0, 1), List(1, 2), List(0, 2), List(0), List(2), List(0, 1, 2), List())
subSecuenciasInc(Seq(10, 20, 30, 40))//HashSet(List(30, 40), List(10, 20), List(10, 40), List(20, 40), List(30), List(10, 30, 40), List(10), List(20, 30, 40), List(20, 30), List(10, 20, 30), List(10, 30), List(), List(20), List(40), List(10, 20, 40), List(10, 20, 30, 40))

val s12 = Seq(20, 30, 10, 15, 16, 17)
println(subsecuenciaIncrementalMasLarga(s12) ) 
val s13 = Seq(20, 30, 10)
println(subsecuenciaIncrementalMasLarga(s13) ) 

val s14 = Seq(1, 2, 3, 4, 5)
subsecuenciaIncrementalMasLarga(s14) //List(1, 2, 3, 4, 5)
val s15 = Seq(5, 10, 15, 14, 13, 12)
subsecuenciaIncrementalMasLarga(s15) //List(5, 10, 14)
val s16 = Seq(2, 4, 8, 7, 6, 5)
subsecuenciaIncrementalMasLarga(s16) //List(2, 4, 7)
val s17 = Seq(0, 1, 1, 2, 3, 5, 4)
subsecuenciaIncrementalMasLarga(s17) //List(0, 1, 2, 3, 5)
val s18 = Seq(10, 20, 30, 25, 35, 45)
subsecuenciaIncrementalMasLarga(s18) //List(10, 20, 30, 35, 45)

sssimlComenzandoEn(4,Seq(10,9,8,7,6,5,4,3,2,1,22,21,20,19,18,17,16,15,14,13,12,11))
sssimlComenzandoEn(12,Seq(10,9,8,7,6,5,4,3,2,1,22,21,20,19,18,17,16,15,14,13,12,11))

sssimlComenzandoEn(0, Seq(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11))
sssimlComenzandoEn(5, Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
sssimlComenzandoEn(3, Seq(5, 6, 7, 1, 2, 3, 4, 8, 9, 10)) 
sssimlComenzandoEn(2, Seq(10, 20, 5, 15, 25, 35, 45)) 
sssimlComenzandoEn(4, Seq(2, 4, 6, 8, 1, 3, 5, 7, 9))
sssimlComenzandoEn(1, Seq(5, 1, 2, 3, 4, 6, 7, 8, 9, 10))


subSecIncMasLargaV2(Seq(10,9,8,7,6,5,4,3,2,1,22,21,20,19,18,17,16,15,14,13,12,11))

subSecIncMasLargaV2(Seq())
subSecIncMasLargaV2(Seq(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))  
subSecIncMasLargaV2(Seq(5, 6, 7, 1, 2, 3, 4, 8, 9, 10))  
subSecIncMasLargaV2(Seq(10, 20, 5, 15, 25, 35, 45))  
subSecIncMasLargaV2(Seq(2, 4, 6, 8, 1, 3, 5, 7, 9))  
subSecIncMasLargaV2(Seq(5, 1, 2, 3, 4, 6, 7, 8, 9, 10))  

//sssimlComenzandoEn2(4,Seq(10,9,8,7,6,5,4,3,2,1,22,21,20,19,18,17,16,15,14,13,12,11))



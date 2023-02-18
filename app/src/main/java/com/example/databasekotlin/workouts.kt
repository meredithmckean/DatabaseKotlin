package com.example.databasekotlin


import androidx.appcompat.app.AppCompatActivity
import com.example.databasekotlin.DatabaseHelper
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.ArrayList

class workouts : AppCompatActivity() {
    private var ftp = 45
    private var fail_count_1 = 0
    private var fail_count_2 = 0
    private var fail_count_3 = 0
    private var pace_fail_20 = 0
    private var pace_fail_30 = 0
    private var pace_fail_40 = 0

    private var pow_pull = ArrayList<Int>()

    //TODO update naming convention?
    private var pz_1: Int
    private var pz_2: Int
    private var pz_3: Int
    private var pz_4: Int
    private var pz_5: Int
    private var pz_6: Int
    private var pz_7: Int

    init {
        //default ftp value for all new users
        // fail count interval 1 workout
        // fail count interval 1 workout
        // fail count interval 1 workout
        // fail count 20-min pace workout
        // fail count 30-min pace workout
        // fail count 40-min pace workout
        pow_pull = ArrayList()
        pz_1 = 0
        pz_2 = 25
        pz_3 = 34
        pz_4 = 40
        pz_5 = 47
        pz_6 = 54
        pz_7 = 67
    }

    // ftp calculator workout method
    // TODO changed from ftp_calc to ftpCalc
    // TODO In main activity change db constructor
    fun ftpCalc(username: String?, db: DatabaseHelper): Int {
        //ftp calculator code that calculates ftp and defines power zones
        //method returns integer ftp value
        //System.out.println("You are now in the ftp workout!");
        //System.out.println("Please row for 20 minutes at a pace that is challenging but sustainable");
        var sum = 0
        var length = 0
        ftp = 50
        while (db.time_33 < 1200) {
            //sum = 50; //testing
            sum += db.power
            length += 1
        }
        val avgPow = sum.toDouble() / length //uncomment
        //define ftp = 95% of average power
        ftp = (0.95 * avgPow).toInt() //uncomment

        // Load power zones
        pz_1 = 0 //Very Easy: <55% of FTP
        pz_2 = (0.56 * ftp).toInt() //Moderate: 56%-75% of FTP
        pz_3 = (0.76 * ftp).toInt() //Sustainable: 76%-90% of FTP
        pz_4 = (0.91 * ftp).toInt() //Challenging: 91%-105% of FTP
        pz_5 = (1.06 * ftp).toInt() //Hard: 106%-120% of FTP
        pz_6 = (1.21 * ftp).toInt() //Very Hard: 121%-150% of FTP
        pz_7 = (1.51 * ftp).toInt() //Max Effort: >151% of FTP

        //uncomment
        // db.updateuserFTP(username, this.ftp, this.pz_1, this.pz_2, this.pz_3, this.pz_4, this.pz_5, this.pz_6, this.pz_7);
        return ftp
    }

    // interval_1 workout method, 20 min
    fun interval_1(db: DatabaseHelper): Int {
        //interval_1 code
        var count = 0
        var k1 = 0
        var k2 = 0
        var k3 = 0
        var k4 = 0
        var k5 = 0
        var k6 = 0
        var k7 = 0
        var k8 = 0
        var k9 = 0
        var k10 = 0
        var k11 = 0
        var k12 = 0
        var k13 = 0
        var k14 = 0
        var k15 = 0
        var k16 = 0
        var k17 = 0
        var k18 = 0
        var k19 = 0
        var k20 = 0
        var k21 = 0
        var k22 = 0
        //for (int i = 0; i < time_33.size(); i++) {
        // 5 min at zone 2
        while (db.getTime_33 <= 300) {
            //TODO how to integrate with UI
            if (k1 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k1 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {    // only consecutive power zone exits increment count
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 340 && db.getTime_33 > 300) {
            if (k2 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k2 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 360 && db.getTime_33 > 340) {
            if (k3 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k3 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 400 && db.getTime_33 > 360) {
            if (k4 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k4 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 420 && db.getTime_33 > 400) {
            if (k5 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k5 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 460 && db.getTime_33 > 420) {
            if (k6 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k6 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 480 && db.getTime_33 > 460) {
            if (k7 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k7 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 520 && db.getTime_33 > 480) {
            if (k8 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k8 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 540 && db.getTime_33 > 520) {
            if (k9 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k9 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 580 && db.getTime_33 > 540) {
            if (k10 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k10 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 600 && db.getTime_33 > 580) {
            if (k11 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k11 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 640 && db.getTime_33 > 600) {
            if (k12 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k12 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 660 && db.getTime_33 > 640) {
            if (k13 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k13 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 700 && db.getTime_33 > 660) {
            if (k14 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k14 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 720 && db.getTime_33 > 700) {
            if (k15 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k15 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 760 && db.getTime_33 > 720) {
            if (k16 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k16 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 780 && db.getTime_33 > 760) {
            if (k17 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k17 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 820 && db.getTime_33 > 780) {
            if (k18 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k18 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 840 && db.getTime_33 > 820) {
            if (k19 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k19 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 40 sec at zone 5
        while (db.getTime_33 <= 880 && db.getTime_33 > 840) {
            if (k20 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k20 = 100
            }
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 20 sec at zone 2
        while (db.getTime_33 <= 900 && db.getTime_33 > 880) {
            if (k21 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k21 = 100
            }
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 5 min at zone 1
        while (db.getTime_33 <= 1200 && db.getTime_33 > 900) {
            if (k22 == 0) {
                println()
                println("**********************")
                println("Row in power zone 1")
                println("**********************")
                println()
                k22 = 100
            }
            if (db.getPower >= pz_2) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 1!!!!")
                    fail_count_1++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        //}
        println("fail count: $fail_count_1")
        interval_predictor("1", fail_count_1)
        return fail_count_1
    }

    // interval_2 workout method, 30 min
    fun interval_2(db: DatabaseHelper): Int {
        //interval_2 code
        println("You are now in the interval_2 workout!")
        var count = 0
        var k1 = 0
        var k2 = 0
        var k3 = 0
        var k4 = 0
        var k5 = 0
        var k6 = 0
        //for (int i = 0; i < time_33.size(); i++) {
        // 6 min at zone 3
        while (db.getTime_33 <= 360) {
            if (k1 == 0) {
                println()
                println("**********************")
                println("Row in power zone 3")
                println("**********************")
                println()
                k1 = 100
            }
            if (db.getPower < pz_3 || db.getPower >= pz_4) {
                count++
                if (count > 2) {
                    println("You aren't in power zone 3!!!!")
                    fail_count_2++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 5 min at zone 1
        while (db.getTime_33 <= 660 && db.getTime_33 > 360) {
            if (k2 == 0) {
                println()
                println("**********************")
                println("Row in power zone 1")
                println("**********************")
                println()
                k2 = 100
            }
            if (db.getPower >= pz_2) {
                count++
                if (count > 2) {
                    println("You aren't in power zone 1!!!!")
                    fail_count_2++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 5 min at zone 4
        while (db.getTime_33 <= 960 && db.getTime_33 > 660) {
            if (k3 == 0) {
                println()
                println("**********************")
                println("Row in power zone 4")
                println("**********************")
                println()
                k3 = 100
            }
            //System.out.println("Row in power zone 4");
            if (db.getPower < pz_4 || db.getPower >= pz_5) {
                count++
                if (count > 2) {
                    println("You aren't in power zone 4!!!!")
                    fail_count_2++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 5 min at zone 1
        while (db.getTime_33 <= 1260 && db.getTime_33 > 960) {
            if (k4 == 0) {
                println()
                println("**********************")
                println("Row in power zone 1")
                println("**********************")
                println()
                k4 = 100
            }
            if (db.getPower >= pz_2) {
                count++
                if (count > 2) {
                    println("You aren't in power zone 1!!!!")
                    fail_count_2++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 4 min at zone 5
        while (db.getTime_33 <= 1500 && db.getTime_33 > 1260) {
            if (k5 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k5 = 100
            }
            //System.out.println("Row in power zone 5");
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 2) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_2++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 5 min at zone 1
        while (db.getTime_33 <= 1800 && db.getTime_33 > 1500) {
            if (k6 == 0) {
                println()
                println("**********************")
                println("Row in power zone 1")
                println("**********************")
                println()
                k6 = 100
            }
            //System.out.println("Row in power zone 1");
            if (db.getPower >= pz_2) {
                count++
                if (count > 2) {
                    println("You aren't in power zone 1!!!!")
                    fail_count_2++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        //}
        println("fail count: $fail_count_2")
        interval_predictor("2", fail_count_2)
        return fail_count_2
    }

    // interval_3 workout method, 40 min
    fun interval_3(db: DatabaseHelper): Int {
        //interval_1 code
        println("You are now in the interval_3 workout!")
        var count = 0
        var k1 = 0
        var k2 = 0
        var k3 = 0
        var k4 = 0
        var k5 = 0
        var k6 = 0
        var k7 = 0
        var k8 = 0
        var k9 = 0
        var k10 = 0
        var k11 = 0

        //for (int i = 0; i < time_33.size(); i++) {
        // 2 min at zone 2
        while (db.getTime_33 <= 120) {
            if (k1 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k1 = 100
            }
            //System.out.println("Row in power zone 2");
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 1 min at zone 5
        while (db.getTime_33 <= 180 && db.getTime_33 > 120) {
            if (k2 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k2 = 100
            }
            //System.out.println("Row at a fast pace!!");
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 2 min at zone 2
        while (db.getTime_33 <= 300 && db.getTime_33 > 180) {
            if (k3 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k3 = 100
            }
            //System.out.println("Row in power zone 2");
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 1 min at zone 5
        while (db.getTime_33 <= 360 && db.getTime_33 > 300) {
            if (k4 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k4 = 100
            }
            //System.out.println("Row at a fast pace!!");
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 2 min at zone 2
        while (db.getTime_33 <= 480 && db.getTime_33 > 360) {
            if (k5 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k5 = 100
            }
            //System.out.println("Row in power zone 2");
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 1 min at zone 5
        while (db.getTime_33 <= 540 && db.getTime_33 > 480) {
            if (k6 == 0) {
                println()
                println("**********************")
                println("Row in power zone 5")
                println("**********************")
                println()
                k6 = 100
            }
            //System.out.println("Row at a fast pace!!");
            if (db.getPower < pz_5 || db.getPower >= pz_6) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 5!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 2 min at zone 2
        while (db.getTime_33 <= 660 && db.getTime_33 > 540) {
            if (k7 == 0) {
                println()
                println("**********************")
                println("Row in power zone 2")
                println("**********************")
                println()
                k7 = 100
            }
            //System.out.println("Row in power zone 2");
            if (db.getPower < pz_2 || db.getPower >= pz_3) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 2!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 10 min at zone 4
        while (db.getTime_33 <= 1260 && db.getTime_33 > 660) {
            if (k8 == 0) {
                println()
                println("**********************")
                println("Row in power zone 4")
                println("**********************")
                println()
                k8 = 100
            }
            //System.out.println("Row in power zone 4");
            if (db.getPower < pz_4 || db.getPower >= pz_5) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 4!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 5 min at zone 1
        while (db.getTime_33 <= 1560 && db.getTime_33 > 1260) {
            if (k9 == 0) {
                println()
                println("**********************")
                println("Row in power zone 1")
                println("**********************")
                println()
                k9 = 100
            }
            //System.out.println("Row in power zone 1");
            if (db.getPower >= pz_2) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 1!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 10 min at zone 4
        while (db.getTime_33 <= 2160 && db.getTime_33 > 1560) {
            if (k10 == 0) {
                println()
                println("**********************")
                println("Row in power zone 4")
                println("**********************")
                println()
                k10 = 100
            }
            //System.out.println("Row in power zone 4");
            if (db.getPower < pz_4 || db.getPower >= pz_5) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 4!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        // 5 min at zone 1
        while (db.getTime_33 <= 2460 && db.getTime_33 > 2160) {
            if (k11 == 0) {
                println()
                println("**********************")
                println("Row in power zone 1")
                println("**********************")
                println()
                k11 = 100
            }
            //System.out.println("Row in power zone 1");
            if (db.getPower >= pz_2) {
                count++
                if (count > 4) {
                    println("You aren't in power zone 1!!!!")
                    fail_count_3++
                    count = 0
                }
            } else {
                count = 0
            }
        }
        //}
        println("fail count: $fail_count_3")
        interval_predictor("3", fail_count_3)
        return fail_count_3
    }

    @Throws(IOException::class)
    fun pace(length: Int, db: DatabaseHelper) {
        //pace code
        var count = 0
        val j = 0
        if (length == 20) {
            println()
            println("**********************")
            println("Begin rowing!")
            println("**********************")
            println()
            //ignore first 5 to allow for user to get to steady state
            //for (int i = 5; i < time_33.size(); i++) {
            while (db.getTime_33 <= 1200) { // less than 20-min
                //if difference between current stroke and previous stroke is greater than 4 watts
                if (Math.abs(db.getPower - db.getPastPower) > 4) {
                    count++
                    if (count > 2) {
                        //TODO incorporate UI?
                        println("Your power output is inconsistent! Try to improve pacing!")
                        pace_fail_20++
                        count = 0
                    }
                } else {
                    count = 0
                }
            }
            //}
            println("fail count 20: " + pace_fail_20)
            pace_predictor("20", pace_fail_20)
        } else if (length == 30) {
            println()
            println("**********************")
            println("Begin rowing!")
            println("**********************")
            println() //ignore first 5 to allow for user to get to steady state
            //for (int i = 5; i < time_33.size(); i++) {
            if (db.getTime_33 <= 1800) { // less than 30-min
                //if difference between current stroke and previous stroke is greater than 4 watts
                if (Math.abs(db.getPower - db.getPastPower) > 4) {
                    count++
                    if (count > 2) {
                        println("Your power output is inconsistent! Try to improve pacing!")
                        pace_fail_30++
                        count = 0
                    }
                } else {
                    count = 0
                }
            }
            //}
            println("fail count 30: " + pace_fail_30)
            pace_predictor("30", pace_fail_30)
        } else if (length == 40) {
            println()
            println("**********************")
            println("Begin rowing!")
            println("**********************")
            println() //ignore first 5 to allow for user to get to steady state
            //for (int i = 5; i < time_33.size(); i++) {
            if (db.getTime_33 <= 2400) { // less than 40-min
                //if difference between current stroke and previous stroke is greater than 4 watts
                if (Math.abs(db.getPower - db.getPastPower) > 4) {
                    count++
                    if (count > 2) {
                        println("Your power output is inconsistent! Try to improve pacing!")
                        pace_fail_40++
                        count = 0
                    }
                } else {
                    count = 0
                }
            }
            //}
            println("fail count 40: " + pace_fail_40)
            pace_predictor("40", pace_fail_40)
        }
    }

    companion object {
        /*    static void two_predictor() {
        //2k predictor code
        System.out.println("You are now in the 2k predictor workout!");
        //
    }*/
        // TODO finish both graphing functions once diego knows how he wants packaged
        /*    public ArrayList<DataPoint> power_pull() {
        //power of pull graph for all workouts
        // had to have sequence be Doubles bc DataPoint class uses double
        System.out.println("You are in power of pull graph method!");

        String file = "C:/Users/alyso/TAMU/2022Fall/ECEN_403_907/Psuedo_Data/pow_pull.csv";
        CSVReaderTest.read_pow_pull(file, pow_pull);
        ArrayList<DataPoint> data = new ArrayList<DataPoint>();
        Double k = 0.0;
        // TODO need to know how many entries in table?
        // TODO does this need to be a new function
        // TODO but the table will have multiple graphs and we are averaging?
        // TODO or is this one graph at a time
        for (int j = 0; j < pow_pull.size(); j++) {
            data.add(new DataPoint(k, pow_pull.get(j)));
            k++;
        }
       return data;
    }*/
        /*    public ArrayList<DataPoint> power_vs_time() {
        //power vs time graph for pace workout
        //time_33 and power
        System.out.println("You are in power vs time graph method!");
        DatabaseHelper db = new DatabaseHelper(workouts.this);

        ArrayList<DataPoint> data = new ArrayList<DataPoint>();
        // TODO need to know length of table of times?
        for (int j = 0; j < time_33.size(); j++) {
            double time = (double) db.getTime_33();
            data.add(new DataPoint(time, db.getPower()));
        }
        return data;
    }*/
        fun interval_predictor(interval_num: String, fail_count: Int) {
            println()
            println("You are in interval predictor method!")
            // TODO incorporate UI
            //finish, did i finish?
            //interval method 1 predictions
            if (interval_num === "1") {
                if (fail_count > 20) {
                    println("You left your power zone a lot! Try redoing your FTP Calculator workout")
                } else {
                    println("You did well! Go again or try a longer interval workout!")
                }
            } else if (interval_num === "2") {
                if (fail_count > 20 && fail_count < 50) {
                    println("You left your power zone often. Try doing the Interval 1 workout")
                } else if (fail_count >= 50) {
                    println("You left your power zone a lot! Try redoing your FTP Calculator workout")
                } else {
                    println("You did well! Go again or try a longer interval workout!")
                }
            } else if (interval_num === "3") {
                if (fail_count > 20 && fail_count < 50) {
                    println("You left your power zone often. Try doing the Interval 2 workout")
                } else if (fail_count >= 50) {
                    println("You left your power zone a lot! Try redoing your FTP Calculator workout")
                } else {
                    println("You did well! Go again or try redoing your FTP Calculator workout!")
                }
            }
        }

        fun pace_predictor(pace_num: String, fail_count: Int) {
            println()
            println("You are in pace predictor method!")
            // TODO integrate UI
            //interval method 1 predictions
            //finish, did i finish?
            if (pace_num === "20") {
                if (fail_count > 14) {
                    println("Your pace was very inconsistent. Try again or do an interval workout to work on fitness")
                } else {
                    println("You did well! Go again or try a longer pace workout!")
                }
            } else if (pace_num === "30") {
                if (fail_count > 14) {
                    println("Your pace was very inconsistent. Try doing the 20 min pace workout instead")
                } else {
                    println("You did well! Go again or try a longer pace workout!")
                }
            } else if (pace_num === "40") {
                if (fail_count > 14) {
                    println("Your pace was very inconsistent. Try doing the 30 min pace workout instead")
                } else {
                    println("You did well! Nice work!")
                }
            }
        } //static void power_predictor() {
        //look at history table and make predictions based on average power of previous workouts
        //if the history table has more than 1 entry
        // if (len(data_table) > 1) {
        //     linear regression of watts with dates
        //     if slope is positive make prediction of how many more workouts to do to get x watts of output
        //     if slope is negative, make prediction of which workouts to work on? which workout is causing the decrease in power output
        //      }
        // }
        //
    }
}
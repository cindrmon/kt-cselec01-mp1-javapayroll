package controller

class Payroll {
    companion object {
        fun computeGrossPay(hoursWorked:Int):Double {
            return if (hoursWorked <= 40) {
                hoursWorked * 500.00
            } else {
                20_000 + ((hoursWorked - 40) * (1.5 * 500))
            }
        }

        fun computeSocialSecurityTax(grossPay:Double):Double {
            return grossPay * 0.015
        }

        fun computeHDMF(grossPay: Double):Double {
            return grossPay * 0.03
        }

        fun computeProfessionalIncomeTax(grossPay:Double):Double {
            return grossPay * 0.1
        }

        fun computeHealthInsurance(dependents:Int):Double {
            return if (dependents >= 3) 300.0 else 0.0
        }

        fun computeNetTakeHomePay(grossPay: Double, socialSecurityTax:Double, HDMF:Double, professionalIncomeTax:Double, healthInsurance:Double):Double {
            return grossPay - socialSecurityTax - HDMF - professionalIncomeTax - healthInsurance
        }
    }
}
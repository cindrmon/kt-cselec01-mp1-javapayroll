package controller

import util.KBInput

class PayrollProgram {
    companion object {
        public fun run() {
            // input variables
            var dependents: Int?
            var hoursWorked: Int?
            var exitChoice: String?

            // output variables
            var grossPay: Double
            var socialSecurityTax: Double
            var hdmf: Double
            var professionalIncomeTax: Double
            var healthInsurance: Double
            var takeHomePay: Double

            while (true) {
                // accept input
                hoursWorked = KBInput.readInteger("Enter the number of hours worked this week: ")
                while (hoursWorked == null || hoursWorked <= 0) {
                    println("Invalid Input! Hours worked must be greater than 0 or a number!")
                    hoursWorked = KBInput.readInteger("Enter the number of hours worked this week: ")
                }

                dependents = KBInput.readInteger("Enter the number of dependents: ")
                while (dependents == null || dependents < 0) {
                    println("Invalid Input! Hours worked must be greater than 0 or a number!")
                    dependents = KBInput.readInteger("Enter the number of dependents: ")
                }

                // calculate input
                grossPay = Payroll.computeGrossPay(hoursWorked)
                socialSecurityTax = Payroll.computeSocialSecurityTax(grossPay)
                hdmf = Payroll.computeHDMF(grossPay)
                professionalIncomeTax = Payroll.computeProfessionalIncomeTax(grossPay)
                healthInsurance = Payroll.computeHealthInsurance(dependents)
                takeHomePay = Payroll.computeNetTakeHomePay(
                    grossPay,
                    socialSecurityTax,
                    hdmf,
                    professionalIncomeTax,
                    healthInsurance
                )

                // print output
                println("\n============== CALCULATED PRICES =================")

                println(
                    "Gross Pay\t\t\t: P" +
                            String.format("%14.2f", grossPay)
                )

                println(
                    "Social Security Tax\t\t: P" +
                            String.format("(%13.2f)", socialSecurityTax)
                )

                println(
                    "HDMF\t\t\t\t: P" +
                            String.format("(%13.2f)", hdmf)
                )

                println(
                    "Professional Income Tax\t\t: P" +
                            String.format("(%13.2f)", professionalIncomeTax)
                )

                println(
                    "Health Insurance\t\t: P" +
                            String.format("(%13.2f)", healthInsurance)
                )

                println("--------------------------------------------------")

                println(
                    "Net Take Home Pay for the Week\t: P" +
                            String.format("%14.2f", takeHomePay)
                )

                println("==================================================")

                // exit program prompt
                exitChoice = KBInput.readString("\nDo you want to calculate another price? [Y/n] ")
                if (exitChoice?.uppercase().equals("N")) break
            }

            println("\n\nThank you for using this simple Payroll Program rewritten in Kotlin!")
        }
    }
}
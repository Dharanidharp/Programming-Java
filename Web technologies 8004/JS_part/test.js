/**
 * validate
 * @author Junyan Wang
 * @version 1.0
 */

;
(function () {
    /**
     * Validation of British language quiz form 
     * 
     * @class Validation
     */
    var Validation = function () {
        /**
         * Constructor
         * 
         * {String} form   quiz form DOM
         * {String} firstVal   fisrt answer
         * {String} secondVal   second answer
         * {String} thirdVal   third answer
         * {String} fourthVal   fourth answer
         */
        this.form = document.forms[0];
        this.firstVal = '';
        this.secondVal = [];
        this.thirdVal = '';
        this.fourthVal = '';

        /**
         * start-up function
         * 
         * @return {Boolean} 
         */
        this.init = function () {
            return this.check();
        }
    }

    /**
     * Methods of Class Validation
     * 
     * {Function} check
     * {Function} getValue
     * {Function} checkEmpty
     */
    Validation.prototype = {
        /**
         * check
         * 
         * @return {Boolean} valid or not
         */
        check: function () {
            this.getValue();
            return false;
        },

        /**
         * getValue
         * 
         */
        getValue: function () {
            this.firstVal = this.form.Q1.value;
            // this.secondVal = this.form.q1.value;
            this.thirdVal = this.form.Q3.value;
            this.fourthVal = this.form.Q4.value;
        },

        /**
         * checkEmpty
         * 
         * @return {Boolean} empty or not
         */
        checkEmpty: function () {
            var res = true;
            if (!this.firstVal || !this.thirdVal || !this.fourthVal) {
                res = false;
            }

            return false;
        }
    }

    var validate = function () {
        var result = new Validation();
        return result.init();
    }

    window.validate = validate;
})()
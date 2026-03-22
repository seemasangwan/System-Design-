import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    /* Required Fields*/
    private  final int  amount;
    private  final  PaymentMethod  paymentMethod;

    /*Optional fields*/
    private final String  description;
    private  final String currency;

    /* Conditional fields*/
    private final  String upiId;
    private final String cardNo;
    private final String cvv;

    /*System generated*/
    private final String  paymentId;
    private final String timeStamp;

    // Payment constructor
    private Payment(PaymentBuilder paymentBuilder)
    {
        this.amount=paymentBuilder.amount;
        this.paymentMethod=paymentBuilder.paymentMethod;
        this.paymentId= UUID.randomUUID().toString();
        this.timeStamp= LocalDateTime.now().toString();
        this.upiId=paymentBuilder.upiId;
        this.cardNo=paymentBuilder.cardNo;
        this.currency=paymentBuilder.currency==null?"INR":paymentBuilder.currency;
        this.cvv=paymentBuilder.cvv;
        this.description=paymentBuilder.description;
    }



    public static   class  PaymentBuilder{
        /* Required Fields*/
        private final int amount;
        private final    PaymentMethod  paymentMethod;

        /*Optional fields*/
        private String  description;
        private String currency;

        /* Conditional fields*/
        private  String upiId;
        private  String cardNo;
        private String cvv;

 
        // constructor for required field
        public  PaymentBuilder(int amount, PaymentMethod paymentMethod)
        {
            this.amount=amount;
            this.paymentMethod=paymentMethod;
        }

        public PaymentBuilder description(String description)
        {
            this.description=description;
            return this;
        }
        public PaymentBuilder currency( String currency){
            this.currency=currency;
            return  this;
        }

        public  PaymentBuilder upiId(String upiId)
        {
            this.upiId=upiId;
            return this;
        }
        public  PaymentBuilder cardNo(String cardNo)
        {
            this.cardNo=cardNo;
            return this;
        }
        public  PaymentBuilder cvv( String cvv)
        {
            this.cvv=cvv;
            return this;
        }
        public Payment build()
        {
            if(amount<=0)
            {
                throw  new IllegalArgumentException("amount should be greater than zero");

            }else if(paymentMethod==PaymentMethod.UPI&&upiId==null)
            {
                throw new IllegalArgumentException("upiId should not be null");
            }
            else if (paymentMethod==PaymentMethod.CARD&& (cardNo==null||cvv==null))
            {
                throw new IllegalArgumentException("please provide card details");
            }

            return new Payment(this);
        }

    }

    public void printPaymentInfo()
    {
        System.out.println("Payment info");
        System.out.println("amount: "+ this.amount);
        System.out.println("paymentId: "+this.paymentId);
        System.out.println("paymentMethod: "+ this.paymentMethod);
        System.out.println("cvv: "+ this.cvv);
        System.out.println("cardNo: "+ this.cardNo);
        System.out.println("currency: "+ this.currency);
        System.out.println("description: " +this.description);
        System.out.println("timestamp: " + this.timeStamp);
    }

}

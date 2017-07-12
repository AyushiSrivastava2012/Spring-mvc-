package vo;

public class BusinessException extends Exception {

	 private final Status status;

     public BusinessException(Status status, String message) {
             super(message);
             this.status = status;
     }

     public BusinessException(Status status, Throwable t) {
             super(t);
             this.status = status;
     }

     public BusinessException(Status status) {
             super();
             this.status = status;
     }

     /**
      * @return the status
      */
     public Status getStatus() {
             return status;
     }


	
}

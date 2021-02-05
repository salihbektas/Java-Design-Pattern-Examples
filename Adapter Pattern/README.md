# Adapter Pattern
Adapter pattern is allows the interface of an existing class to be used as another interface. It is often used to make existing classes work with others without modifying their source code.

In the scenario designed for the adapter pattern, a company renewed its payment method. Objects that will work with the new method must implement the ModernPayment interface. However, the company wants objects that work with the old payment method called TurboPayment to be supported in the new payment method, and the objects that work with the old payment method are binary. So there is no question of making changes in the old classes.

The adapter class, which implements the ModernPayment interface and contains reference to TurboPayment, was written under the name of Payment. Using objects from the old payment method in this class was able to fulfill the requirements of the new payment method.
package summer.camp.commands

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseCommand<T>(
@TargetAggregateIdentifier
        open val id : T
)
class CreateCustomerCommand(
        override val id : String,
        val name :String,
        val email :String
):BaseCommand<String>(id)

class UpdateCustomerCommand(
        override val id : String,
        val name :String,
        val email :String
):BaseCommand<String>(id)
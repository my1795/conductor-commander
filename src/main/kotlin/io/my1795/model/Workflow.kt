package io.my1795.model

import io.quarkus.runtime.annotations.RegisterForReflection
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonPrimitive

@Serializable
@RegisterForReflection
data class Workflow(
        var createTime: Long,
        var updateTime: Long,
        var status: WorkflowStatus,
        var workflowId: String,
        @Contextual var input: HashMap<String,@Contextual JsonPrimitive>,
        @Contextual var output: HashMap<String,@Contextual JsonPrimitive>,
        var workflowDefinition: WorkflowDef
)



@Serializable
data class WorkflowDef(
        var createTime: Long,
        var name: String,
        var description: String,
        var version: Int,


        )

@Serializable
enum class WorkflowStatus {
        RUNNING,
     COMPLETED,
     FAILED,
     TIMED_OUT,
     TERMINATED,
     PAUSED
}
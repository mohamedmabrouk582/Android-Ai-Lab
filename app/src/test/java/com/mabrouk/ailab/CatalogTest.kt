package com.mabrouk.ailab

import com.mabrouk.ailab.inference.InferenceLab
import com.mabrouk.ailab.tensors.TensorsLab
import com.mabrouk.ailab.tokens.TokensLab
import com.mabrouk.ailab.embeddings.EmbeddingsLab
import com.mabrouk.ailab.outputs.OutputsLab
import com.mabrouk.ailab.transformers.TransformersLab
import com.mabrouk.ailab.prompting.PromptingLab
import com.mabrouk.ailab.rag.RagLab
import com.mabrouk.ailab.agents.AgentsLab
import com.mabrouk.ailab.evaluation.EvaluationLab
import com.mabrouk.ailab.quantization.QuantizationLab
import com.mabrouk.ailab.privacy.PrivacyLab
import com.mabrouk.ailab.mlkittasks.MlkitTasksLab
import com.mabrouk.ailab.promptapi.PromptApiLab
import com.mabrouk.ailab.structuredoutput.StructuredOutputLab
import com.mabrouk.ailab.genaitasks.GenaiTasksLab
import com.mabrouk.ailab.litertcpu.LitertCpuLab
import com.mabrouk.ailab.litertgpu.LitertGpuLab
import com.mabrouk.ailab.litertruntime.LitertRuntimeLab
import com.mabrouk.ailab.modeldelivery.ModelDeliveryLab
import com.mabrouk.ailab.ondevicerag.OnDeviceRagLab
import com.mabrouk.ailab.litertlm.LitertLmLab
import com.mabrouk.ailab.speech.SpeechLab
import com.mabrouk.ailab.camerax.CameraxLab
import com.mabrouk.ailab.performance.PerformanceLab
import com.mabrouk.ailab.appfunctions.AppfunctionsLab
import com.mabrouk.ailab.testing.TestingLab
import com.mabrouk.ailab.playpolicy.PlayPolicyLab
import com.mabrouk.ailab.lab.requireFullCatalog
import org.junit.Assert.assertTrue
import org.junit.Test

class CatalogTest {
    @Test
    fun catalog_hasTwentyEightLabs() {
        val labs = listOf(
        InferenceLab.lab,
        TensorsLab.lab,
        TokensLab.lab,
        EmbeddingsLab.lab,
        OutputsLab.lab,
        TransformersLab.lab,
        PromptingLab.lab,
        RagLab.lab,
        AgentsLab.lab,
        EvaluationLab.lab,
        QuantizationLab.lab,
        PrivacyLab.lab,
        MlkitTasksLab.lab,
        PromptApiLab.lab,
        StructuredOutputLab.lab,
        GenaiTasksLab.lab,
        LitertCpuLab.lab,
        LitertGpuLab.lab,
        LitertRuntimeLab.lab,
        ModelDeliveryLab.lab,
        OnDeviceRagLab.lab,
        LitertLmLab.lab,
        SpeechLab.lab,
        CameraxLab.lab,
        PerformanceLab.lab,
        AppfunctionsLab.lab,
        TestingLab.lab,
        PlayPolicyLab.lab,
        )
        requireFullCatalog(labs)
        labs.forEach { lab ->
            assertTrue(lab.idea.isNotBlank())
            assertTrue(lab.runInputs.isNotEmpty())
            assertTrue(lab.passCondition.isNotBlank())
            assertTrue(lab.sources.all { it.startsWith("https://") })
        }
    }
}

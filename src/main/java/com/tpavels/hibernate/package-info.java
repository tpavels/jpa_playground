@GenericGenerator(
        name = "ID_GENERATOR",
        strategy = "enhanced-sequence", //sequential numeric values, see org.hibernate.id.enhanced.SequenceStyleGenerator
        parameters = {
                @Parameter(
                        name = "sequence_name",
                        value = "TPAVELS_SEQ"
                ),
                @Parameter(
                        name = "initial_value",
                        value = "100"
                )
        }
)
package com.tpavels.hibernate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
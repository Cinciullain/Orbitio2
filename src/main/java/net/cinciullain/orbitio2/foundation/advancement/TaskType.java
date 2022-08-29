package net.cinciullain.orbitio2.foundation.advancement;

import net.minecraft.advancements.FrameType;

/**
 * TaskTypes is the identity type of an advancement. Each advancement will be of a type, giving its basic properties to be assigned.
 */
public enum TaskType
{
    SILENT(FrameType.TASK, false, false, false),
    NORMAL(FrameType.TASK, true, false, false),
    NOISY(FrameType.TASK, true, true, false),
    EXPERT(FrameType.GOAL, true, true, false),
    SECRET(FrameType.GOAL, true, true, true)
    ;
    private FrameType frameType;
    private boolean toast;
    private boolean announce;
    private boolean hide;

    TaskType(FrameType frameType, boolean toast, boolean announce, boolean hide)
    {
        this.frameType = frameType;
        this.toast = toast;
        this.announce = announce;
        this.hide = hide;
    }
}

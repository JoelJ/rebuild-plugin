/*
 *  The MIT License
 *
 *  Copyright 2012 Rino Kadijk.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.sonyericsson.rebuild;

/**
 * Reschedules last completed build for the project if available.
 * Otherwise it behaves as if the user clicked on the build now button.
 */
public class RebuildLastCompletedBuildAction extends RebuildAction {

    @Override
    public String getUrlName() {
        boolean isBuildable = getProject() != null && getProject().isBuildable();
        boolean hasCompletedBuild = getProject().getLastCompletedBuild() != null;
        if (isBuildable) {
            if (hasCompletedBuild) {
                return getProject().getLastCompletedBuild().getNumber() + "/rebuild";
            } else {
                return "build?delay=0sec";
            }
        } else {
            return null;
        }
    }

    @Override
    public String getDisplayName() {
        return "Rebuild Last";
    }
}

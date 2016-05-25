package projekt5;

import java.util.Locale;

public class StoryPL extends Stories{
	
	private Pages pages;
    
    @Override
    protected Locale locale() {
        return new Locale("pol");
    }

    @Override
    protected String storyPattern() {
        return "**/*.scenariusz";
    }

    @Override
    protected Object localizedSteps() {
        return new MealsSteps(pages);
    }
}

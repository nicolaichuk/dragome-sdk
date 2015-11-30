package com.dragome.render.serverside.swing;

import java.awt.Component;
import java.awt.Container;

import com.dragome.templates.ContentImpl;
import com.dragome.templates.TemplateImpl;
import com.dragome.templates.interfaces.Template;
import com.dragome.templates.interfaces.TemplateLoadingStrategy;

public class SwingTemplateLoadingStrategy implements TemplateLoadingStrategy
{
	public static Container mainPanel;

	public void loadMainTemplate(String templateName)
	{
	}

	public void hideContainer()
	{
	}

	public void setupContainer()
	{
	}

	public void showContainer()
	{
	}

	public Template loadTemplate(String templateName, String aContainerId)
	{
		return null;
	}

	public Template loadTemplate(String templateName)
	{
		return null;
	}

	public Template getMainTemplate()
	{
		TemplateImpl parent= new TemplateImpl("main");
		return createTemplate(mainPanel, parent);
	}

	public static Template createTemplate(Component component, Template parent)
	{
		Template template= parent;
		if (component.getName() != null)
		{
			template= new TemplateImpl(component.getName());
			template.setContent(new ContentImpl<Object>(component));
		}
		template.setFiringEvents(false);

		if (component instanceof Container)
		{
			Container childContainer= (Container) component;
			for (Component child : childContainer.getComponents())
			{
				Template createTemplate= createTemplate(child, template);

				template.setFiringEvents(false);
				
				if (createTemplate != null && createTemplate != template)
					template.addChild(createTemplate);
				
				template.setFiringEvents(true);

				createTemplate.setFiringEvents(true);
			}
		}
		return template;
	}

	public Template loadTemplateCloned(String templateName, String aContainerId)
	{
		return null;
	}

}

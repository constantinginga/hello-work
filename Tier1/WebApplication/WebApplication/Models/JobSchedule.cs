using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Reflection;
using System.Threading.Tasks;

namespace WebApplication.Models
{

    static public class JobSchedule
    {
        public enum Schedule
        {
            [Description("Full time")] FullTime,
            [Description("Part time")] PartTime,
            [Description("Internship")] Internship,
            [Description("Volunteering")] Volunteering
        }

        public static string ToDescription<T>(this T value) where T : struct
        {
            if (!typeof(T).IsEnum)
            {
                throw new ArgumentException("Not an enum");
            }
            var fieldName = Enum.GetName(typeof(T), value);
            if (fieldName == null)
            {
                return string.Empty;
            }
            var fieldInfo = typeof(T).GetField(fieldName, BindingFlags.DeclaredOnly | BindingFlags.Public | BindingFlags.Static);
            if (fieldInfo == null)
            {
                return string.Empty;
            }
            var descriptionAttribute = (DescriptionAttribute)fieldInfo.GetCustomAttributes(typeof(DescriptionAttribute), false).FirstOrDefault();
            if (descriptionAttribute == null)
            {
                return fieldInfo.Name;
            }
            return descriptionAttribute.Description;
        }
    }

}

using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Text.Json.Serialization;
using System.Threading.Tasks;
using Newtonsoft.Json.Converters;
using WebApplication.Data.Applications;

namespace WebApplication.Models
{
    public class Application
    {
        public Application()
        {
        }
        [Required] [JsonPropertyName("Id")] public int Id { get; set; }

        [Required] [JsonPropertyName("JobId")] public int JobId { get; set; }
        [JsonPropertyName("Details")] public string Details { get; set; }
        [JsonPropertyName("employeEmail")] public string employeEmail { get; set; }
        [JsonPropertyName("employerEmail")] public string employerEmail { get; set; }
        [JsonPropertyName("Status")] public int Status { get; set; }
        [JsonPropertyName("Name")] public string Name { get; set; }
        [JsonPropertyName("Files")] public List<string> Files { get; set; }

        public string AddFile(string fileName, Byte[] file)
        {
            Files.Add(fileName);
            return Convert.ToBase64String(file);
        }

        public static Byte[] GetFile(string file)
        {
            return Convert.FromBase64String(file);
        }
    }
}